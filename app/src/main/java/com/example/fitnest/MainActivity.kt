package com.example.fitnest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.example.fitnest.ui.theme.FitnestTheme

class MainActivity : ComponentActivity() {

    private val onNavigationItemSelectedListener = com.example.fitnest.bottom_nav_menu.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_news_feed -> {
                switchFragment(NewsFeedFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_goals -> {
                switchFragment(GoalsFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_planning -> {
                switchFragment(PlanFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_help -> {
                switchFragment(HelpFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNav)
        bottomNav.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        // Set the initial fragment
        if (savedInstanceState == null) {
            switchFragment(NewsFeedFragment())
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FitnestTheme {
        Greeting("Android")
    }
}
