import styles from "./Header.module.css";
import Logo from "../../images/football-bingo-logo.svg";

const Header = () => {
  return (
    <header className={styles.header}>
      <div className={styles.headerLeft}>
        <img src={Logo} />
      </div>
      <div className={styles.headerRight}>
        <div className={styles.titleStack}>
          <h1>FOOTBALL</h1>
          <h1>BINGO</h1>
        </div>
      </div>
    </header>
  );
};

export default Header;
