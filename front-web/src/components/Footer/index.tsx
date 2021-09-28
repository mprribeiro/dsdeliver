import './styles.css'
import {ReactComponent as Linkedin} from './linkedin.svg'
import {ReactComponent as Instagram} from './instagram.svg'

function Footer() {
    return (
        <footer className="main-footer">
            App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
            <div className="footer-icons">
                <a href="https://www.linkedin.com/in/mprribeiro/" target="_new">
                    <Linkedin />
                </a>
                <a href="https://www.instagram.com/rabelor_/" target="_new">
                    <Instagram />
                </a>
            </div>
        </footer>
    );
}

export default Footer;