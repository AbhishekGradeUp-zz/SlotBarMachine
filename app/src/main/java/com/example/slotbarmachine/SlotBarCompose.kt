package com.example.slotbarmachine

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slotbarmachine.ui.theme.Color_808080

@Composable
@Preview
fun App() {
    MaterialTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize().background(Color_808080)

        ) {
            val stopWatch = remember { SlotBarHelper() }
            Column(modifier = Modifier.fillMaxSize()) {
                TopAppBar(title = {
                    Text("Squad Game")
                })

                Spacer(modifier = Modifier.padding(30.dp))

                StopWatchDisplay(
                    gameRound =  stopWatch.gameRound,
                    gamePoint = stopWatch.gamePoints,
                    isMatchFound =  stopWatch.isMatchFound,
                    formattedTime = stopWatch.SquadName,
                    formattedTimeSecond = stopWatch.teamMemberName,
                    onStartClick = stopWatch::startGame,
                    onPauseClick = stopWatch::pauseGame,
                    onResetClick = stopWatch::resetGame,
                )
            }

        }
    }
}