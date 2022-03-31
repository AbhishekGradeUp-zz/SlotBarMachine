package com.example.slotbarmachine

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.slotbarmachine.util.Utility
import com.example.slotbarmachine.util.Utility.teamMap
import kotlinx.coroutines.*

class SlotBarHelper {
    var SquadName by mutableStateOf("Squad Name")
    var teamMemberName by mutableStateOf("Team Member")
    var isMatchFound by mutableStateOf(false)
    var gamePoints by mutableStateOf(0)
    var gameRound by mutableStateOf(0)

    private var coroutineScope = CoroutineScope(Dispatchers.Main)
    private var IsGameActivity = false
    private var counter = 0
    fun startGame() {
        if(IsGameActivity) return
        coroutineScope.launch {
            this@SlotBarHelper.IsGameActivity = true
            counter = 1
            while(this@SlotBarHelper.IsGameActivity) {
                delay(20L)
                isMatchFound = false
                SquadName =  Utility.membersList.get((0..Utility.membersList.size-1).random())
                teamMemberName =  Utility.squadList.get((0..Utility.squadList.size-1).random())
                counter = counter+1;
                if(counter > 100)
                {
                    pauseGame()
                }
            }
        }
    }

    fun pauseGame() {
        IsGameActivity = false
        counter = 0
        gameRound = gameRound+1
        Utility.buildTeamMap()
        if(teamMap.get(SquadName).equals(teamMemberName))
        {
            isMatchFound = true
            gamePoints = gamePoints + 1
        }
        if(gameRound == 5)
        {
            resetGame()
        }
    }

    fun resetGame() {
        coroutineScope.cancel()
        coroutineScope = CoroutineScope(Dispatchers.Main)
        gamePoints = 0
        gameRound =0
        SquadName = "Squad Name"
        teamMemberName = "Team Member"
        IsGameActivity = false
    }


}