import axios from "axios"
import { useEffect, useState } from "react"
import DatePicker from "react-datepicker"
import "react-datepicker/dist/react-datepicker.css"
import { BASE_URL } from "../../utils/request"
import { Sale } from "../models/sale"
import NotificationButton from "../NotificationButton"
import "./styles.css"

function SalesCard() {

  const min = new Date(new Date().setDate(new Date().getDate() - 365))
  const max = new Date()

  const [minimumDate, setMinimumDate] = useState(min)
  const [maximumDate, setMaximumDate] = useState(max)

  const [sales, setSales] = useState<Sale[]>([])

  useEffect(() => {
    axios.get(`${BASE_URL}/sales`)
      .then(response => {
        setSales(response.data.content) //atualizar o useState com o valor que volta da api
      })
  }, [])


  return (
    <div className="card">
      <h2 className="sales-title">Vendas</h2>
      <div>
        <div className="form-control-container">
          <DatePicker
            selected={minimumDate}
            onChange={(date: Date) => setMinimumDate(date)}
            className="form-control"
            dateFormat="dd/MM/yyyy"
          />
        </div>
        <div className="form-control-container">
          <DatePicker
            selected={maximumDate}
            onChange={(date: Date) => setMaximumDate(date)}
            className="form-control"
            dateFormat="dd/MM/yyyy"
          />
        </div>
      </div>

      <div>
        <table className="sales-table">
          <thead>
            <tr>
              <th className="show992">ID</th>
              <th className="show576">Data</th>
              <th>Vendedor</th>
              <th className="show992">Visitas</th>
              <th className="show992">Vendas</th>
              <th>Total</th>
              <th>Notificar</th>
            </tr>
          </thead>
          <tbody>
            {sales.map(sale => {
              return (
              <tr key={sale.id}>
                <td className="show992">{sale.id}</td>
                <td className="show576">{new Date(sale.date).toLocaleDateString()}</td>
                <td>{sale.sellerName}</td>
                <td className="show992">{sale.visited}</td>
                <td className="show992">{sale.deals}</td>
                <td>R$ {sale.amount.toFixed(2)}</td>
                <td>
                  <div className="red-btn-container">
                    <NotificationButton />
                  </div>
                </td>
              </tr>)
            })

            }
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default SalesCard;
