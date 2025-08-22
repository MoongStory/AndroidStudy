// 학습 리소스 둘러보기 -> 입문자 대상 -> 단원 2: 앱 UI 빌드 -> 연습: 클릭 동작
// 아래 링크부터 이어서
// https://developer.android.com/codelabs/basic-android-kotlin-compose-button-click-practice-problem?hl=ko&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-2%3Fhl%3Dko%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-button-click-practice-problem#2
// "시작하기"부터 이어서 하면 됨.

package com.example.androidstudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidstudy.ui.theme.AndroidStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidStudyTheme {
                LemonadeApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {

}

@Composable
fun LemonTextAndImage() {

}

@Preview
@Composable
fun LemonadePreview() {
    AndroidStudyTheme {
        LemonadeApp()
    }
}