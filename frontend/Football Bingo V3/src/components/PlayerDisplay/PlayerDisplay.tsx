import { PlayerData } from "../../types";
import styles from "./PlayerDisplay.module.css";

interface PlayerDisplayProps {
  player: PlayerData;
  onSkip: () => void;
}

const PlayerDisplay = ({ player, onSkip }: PlayerDisplayProps) => {
  return (
    <div className={styles.playerDisplay}>
      <div className={styles.playerCard}>
        <img src={player.imageUrl} alt={player.name} />
        <h2>{player.name}</h2>
      </div>
      <button className={styles.skipButton} onClick={onSkip}>
        SKIP PLAYER
      </button>
    </div>
  );
};

export default PlayerDisplay;
