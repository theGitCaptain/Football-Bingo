export interface BingoSquareData {
  id: string;
  name: string;
  imageUrl: string;
}

export interface PlayerData {
  id: string;
  name: string;
  imageUrl: string;
  validSquareIds: string[];
}
