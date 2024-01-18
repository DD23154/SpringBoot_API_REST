const axios = require('axios');

const url = 'http://localhost:8080';
const urlTeam = url + '/teams';
const urlPlayer = url + '/players';

const team1 = {
  "name": "team 1"
}

const player1 = { 
  "name": "player 1", 
  "team": { "id": 1 } 
}

const player2 = { 
  "name": "player 2", 
  "team": { "id": 1 } 
}

const postTeam = async (body) => {
  try {
    const response = await axios.post(urlTeam, body);
    console.log(response.status);
  } catch (error) {
    console.log(error);
  }
};

const getTeams = async () => {
  try {
    const response = await axios.get(urlTeam);
    console.log(`${response.status} The response to the get teams request: `);

    const teams = response.data;
    
    teams.forEach(team => {
      console.log(`Team ${team.id}: ${team.name}`);
      
      if (team.players && team.players.length > 0) {
        console.log("Players:");
        team.players.forEach(player => {
          console.log(`  id: ${player.id}, name: ${player.name}`);
        });
      } else {
        console.log("No players in this team.");
      }
    });
  } catch (error) {
    console.log(error);
  }
};

const postPlayer = async (body) => {
  try {
    const response = await axios.post(urlPlayer, body);
    console.log(response.status);
  } catch (error) {
    console.log(error);
  }
};

const getPlayers = async () => {
  try {
    const response = await axios.get(urlPlayer);
    console.log(`${response.status} The response to the get players request: `, response.data);
  } catch (error) {
    console.log(error);
  }
};


postTeam(team1)
  .then(() => getTeams())
  .then(() => postPlayer(player1))
  .then(() => getPlayers())
  .then(() => postPlayer(player2))
  .then(() => getPlayers())
  .then(() => getTeams())
  .catch(error => console.log(error));