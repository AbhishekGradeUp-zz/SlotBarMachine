package com.example.slotbarmachine

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StopWatchDisplay(
    gameRound: Int,
    gamePoint: Int,
    isMatchFound: Boolean,
    formattedTime: String,
    formattedTimeSecond: String,
    onStartClick: () -> Unit,
    onPauseClick: () -> Unit,
    onResetClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var gameRoundlocal = gameRound +1
                Text(
                    text = "Round: $gameRoundlocal",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.Black
                )
                Spacer(Modifier.height(20.dp))


                var text = if (isMatchFound &&  gameRound != 5) "Match Found" else ""
                    Text(
                        text = text,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color.Black
                    )
                Spacer(Modifier.height(20.dp))

                Text(
                    text = formattedTimeSecond,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.Blue
                )
                Spacer(Modifier.height(16.dp))

                Text(
                    text = formattedTime,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.Blue
                )
            }

            Spacer(Modifier.height(50.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onStartClick) {
                    Text("Lets Go")
                }

            }
        Spacer(Modifier.height(50.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {

            var resultstring  = if(gameRound == 5) "Your Score: " else "Your Points:  "
            Text(
                text = resultstring,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.Black
            )
            var maxPoint = 5
            Text(
                text = "$gamePoint/$maxPoint",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.Blue
            )
        }

    }
}