import logo from '../../assets/img/logo.svg'

import './styles.css'

function Header() {
    return (
      <header>
        <div className='logo-container'>
            <img src={logo} alt="logo" />
            <h1>Spring + React</h1>
            <p>
                Desenvolvido por
                <a href="https://www.instagram.com/wthallys_"> @wthallys_</a>
            </p>
        </div>
      </header>
    )
  }
  
  export default Header