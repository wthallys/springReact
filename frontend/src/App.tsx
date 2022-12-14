import Header from "./components/Header"
import SalesCard from "./components/SalesCard"

import './index.css'

function App() {
  return (
    <>
      <Header />
      <main>
        <section id="sales">
          <div className="container">
            <SalesCard />
          </div>  
        </section>
      </main>
    </>
  )
}

export default App
