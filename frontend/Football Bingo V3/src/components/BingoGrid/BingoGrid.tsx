import { useState } from "react";
import styles from "./BingoGrid.module.css";
import { BingoSquareData } from "../../types";
import BingoSquare from "../BingoSquare/BingoSquare";

interface BingoGridProps {
  squares: BingoSquareData[];
  selectedSquares: Set<string>;
  incorrectSquare: string | null;
  onSquareClick: (id: string) => void;
}

const BingoGrid = ({
  squares,
  selectedSquares,
  incorrectSquare,
  onSquareClick,
}: BingoGridProps) => {
  //   const [selectedSquares, setSelectedSquares] = useState<Set<string>>(
  //     new Set()
  //   );

  //   const toggleSquare = (id: string) => {
  //     setSelectedSquares((prev) => {
  //       const newSet = new Set(prev);
  //       if (newSet.has(id)) {
  //         newSet.delete(id);
  //       } else {
  //         newSet.add(id);
  //       }
  //       return newSet;
  //     });
  //   };

  return (
    <div className={styles.grid}>
      {squares.map((square) => (
        <BingoSquare
          key={square.id}
          data={square}
          isSelected={selectedSquares.has(square.id)}
          isIncorrect={incorrectSquare === square.id}
          onClick={() => onSquareClick(square.id)}
        />
      ))}
    </div>
  );
};

export default BingoGrid;
