import { useState } from "react";
import BingoGrid from "../components/BingoGrid/BingoGrid";
import Header from "../components/Header/Header";
import { BingoSquareData, PlayerData } from "../types";
import PlayerDisplay from "../components/PlayerDisplay/PlayerDisplay";

const dummyData: BingoSquareData[] = [
  {
    id: "1",
    name: "LAZIO",
    imageUrl: "https://playfootball.games/media/categories/153.webp",
  },
  {
    id: "2",
    name: "BRAZIL",
    imageUrl: "https://playfootball.games/media/categories/6.webp",
  },
  {
    id: "3",
    name: "WEST HAM",
    imageUrl: "https://playfootball.games/media/categories/149.webp",
  },
  {
    id: "4",
    name: "SPAIN",
    imageUrl: "https://playfootball.games/media/categories/2.webp",
  },
  {
    id: "5",
    name: "MILAN",
    imageUrl: "https://playfootball.games/media/categories/83.webp",
  },
  {
    id: "6",
    name: "INTER",
    imageUrl: "https://playfootball.games/media/categories/99.webp",
  },
  {
    id: "7",
    name: "MANAGED BY VAN GAAL",
    imageUrl: "https://playfootball.games/media/categories/304.webp",
  },
  {
    id: "8",
    name: "PSG",
    imageUrl: "https://playfootball.games/media/categories/172.webp",
  },
  {
    id: "9",
    name: "CHAMPIONS LEAGUE GOLDEN BOOT WINNER SINCE 1992/93",
    imageUrl: "https://playfootball.games/media/categories/375.webp",
  },
  {
    id: "10",
    name: "PLAYED WITH IBRAHIMOVIC",
    imageUrl: "https://playfootball.games/media/categories/316.webp",
  },
  {
    id: "11",
    name: "WORLD CUP WINNER SINCE 1958",
    imageUrl: "https://playfootball.games/media/categories/354.webp",
  },
  {
    id: "12",
    name: "COPA AMERICA WINNER SINCE 1960",
    imageUrl: "https://playfootball.games/media/categories/356.webp",
  },
  {
    id: "13",
    name: "PORTO",
    imageUrl: "https://playfootball.games/media/categories/186.webp",
  },
  {
    id: "14",
    name: "PLAYED IN BRAZILIAN TOP DIV SINCE 1996",
    imageUrl: "https://playfootball.games/media/categories/291.webp",
  },
  {
    id: "15",
    name: "CROATIA",
    imageUrl: "https://playfootball.games/media/categories/15.webp",
  },
  {
    id: "16",
    name: "FRANCE",
    imageUrl: "https://playfootball.games/media/categories/3.webp",
  },
];

const dummyPlayers: PlayerData[] = [
  {
    id: "p1",
    name: "Emerson",
    imageUrl:
      "https://img.a.transfermarkt.technology/portrait/header/181778-1660636930.jpg?lm=1",
    validSquareIds: ["2", "3", "9", "14"],
  },
  {
    id: "p2",
    name: "Kylian Mbappé",
    imageUrl:
      "https://img.a.transfermarkt.technology/portrait/header/342229-1682683695.jpg?lm=1",
    validSquareIds: ["8", "10", "11", "16"],
  },
  {
    id: "p3",
    name: "Mario Götze",
    imageUrl:
      "https://img.a.transfermarkt.technology/portrait/header/74842-1663065102.jpg?lm=1",
    validSquareIds: ["11"],
  },
  {
    id: "p4",
    name: "Konrad Laimer",
    imageUrl:
      "https://img.a.transfermarkt.technology/portrait/header/223967-1700659266.jpg?lm=1",
    validSquareIds: [],
  },
];

const BingoPage = () => {
  const [selectedSquares, setSelectedSquares] = useState<Set<string>>(
    new Set()
  );
  const [currentPlayerIndex, setCurrentPlayerIndex] = useState(0);
  const [incorrectSquare, setIncorrectSquare] = useState<string | null>(null);

  const currentPlayer = dummyPlayers[currentPlayerIndex];

  const handleSquareClick = (squareId: string) => {
    if (selectedSquares.has(squareId)) {
      return;
    }

    if (currentPlayer.validSquareIds.includes(squareId)) {
      setSelectedSquares((prev) => new Set([...prev, squareId]));
      goToNextPlayer();
    } else {
      setIncorrectSquare(squareId);
      setTimeout(() => {
        setIncorrectSquare(null);
        goToNextPlayer();
      }, 500);
    }
  };

  const goToNextPlayer = () => {
    setCurrentPlayerIndex((prev) =>
      prev < dummyPlayers.length - 1 ? prev + 1 : 0
    );
  };

  return (
    <>
      <Header />
      <PlayerDisplay player={currentPlayer} onSkip={goToNextPlayer} />
      <BingoGrid
        squares={dummyData}
        onSquareClick={handleSquareClick}
        selectedSquares={selectedSquares}
        incorrectSquare={incorrectSquare}
      />
    </>
  );
};

export default BingoPage;
