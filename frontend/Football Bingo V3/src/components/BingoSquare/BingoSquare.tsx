import styles from "./BingoSquare.module.css";
import { BingoSquareData } from "../../types";

interface BingoSquareProps {
  data: BingoSquareData;
  isSelected?: boolean;
  isIncorrect?: boolean;
  onClick?: () => void;
}

const BingoSquare = ({
  data,
  isSelected = false,
  isIncorrect = false,
  onClick,
}: BingoSquareProps) => {
  return (
    <div
      className={`${styles.square} ${isSelected ? styles.selected : ""} ${
        isIncorrect ? styles.incorrect : ""
      }`}
      onClick={onClick}
    >
      <img src={data.imageUrl} alt={data.name} />
      <p>{data.name}</p>
    </div>
  );
};

export default BingoSquare;
