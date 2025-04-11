import { Routes, Route } from "react-router-dom";
import BingoPage from "./pages/BingoPage";

const AppRoutes = () => {
  return (
    <Routes>
      <Route path="/" element={<BingoPage />} />
    </Routes>
  );
};

export default AppRoutes;
