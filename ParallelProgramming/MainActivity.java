   public class MainActivity extends AppCompatActivity {
   
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        FirstTask firstTask =new FirstTask();
        firstTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        SecondTask secondTask =new SecondTask();
        secondTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
           
    }
    }
    
    /*
              Log Output is as Follows :
 2012-01-01 12:41:20.379 4049-4112/com.deadline_tech.flexyboxbeta D/Nazim: First Task0
2012-01-01 12:41:20.379 4049-4110/com.deadline_tech.flexyboxbeta D/Nazim: Second Task0
2012-01-01 12:41:20.481 4049-4110/com.deadline_tech.flexyboxbeta D/Nazim: Second Task1
2012-01-01 12:41:20.481 4049-4112/com.deadline_tech.flexyboxbeta D/Nazim: First Task1
2012-01-01 12:41:20.583 4049-4112/com.deadline_tech.flexyboxbeta D/Nazim: First Task2
2012-01-01 12:41:20.583 4049-4110/com.deadline_tech.flexyboxbeta D/Nazim: Second Task2
2012-01-01 12:41:20.683 4049-4112/com.deadline_tech.flexyboxbeta D/Nazim: First Task3
2012-01-01 12:41:20.683 4049-4110/com.deadline_tech.flexyboxbeta D/Nazim: Second Task3
2012-01-01 12:41:20.784 4049-4110/com.deadline_tech.flexyboxbeta D/Nazim: Second Task4
2012-01-01 12:41:20.788 4049-4112/com.deadline_tech.flexyboxbeta D/Nazim: First Task4
2012-01-01 12:41:20.885 4049-4110/com.deadline_tech.flexyboxbeta D/Nazim: Second Task5
2012-01-01 12:41:20.890 4049-4112/com.deadline_tech.flexyboxbeta D/Nazim: First Task5
2012-01-01 12:41:20.986 4049-4110/com.deadline_tech.flexyboxbeta D/Nazim: Second Task6
2012-01-01 12:41:20.991 4049-4112/com.deadline_tech.flexyboxbeta D/Nazim: First Task6
2012-01-01 12:41:21.086 4049-4110/com.deadline_tech.flexyboxbeta D/Nazim: Second Task7
2012-01-01 12:41:21.093 4049-4112/com.deadline_tech.flexyboxbeta D/Nazim: First Task7
2012-01-01 12:41:21.187 4049-4110/com.deadline_tech.flexyboxbeta D/Nazim: Second Task8
2012-01-01 12:41:21.194 4049-4112/com.deadline_tech.flexyboxbeta D/Nazim: First Task8
2012-01-01 12:41:21.287 4049-4110/com.deadline_tech.flexyboxbeta D/Nazim: Second Task9
2012-01-01 12:41:21.294 4049-4112/com.deadline_tech.flexyboxbeta D/Nazim: First Task9
2012-01-01 12:41:21.387 4049-4110/com.deadline_tech.flexyboxbeta D/Nazim: Second Task10
2012-01-01 12:41:21.394 4049-4112/com.deadline_tech.flexyboxbeta D/Nazim: First Task10
2012-01-01 12:41:21.491 4049-4110/com.deadline_tech.flexyboxbeta D/Nazim: Second Task11
2012-01-01 12:41:21.494 4049-4112/com.deadline_tech.flexyboxbeta D/Nazim: First Task11
2012-01-01 12:41:21.591 4049-4110/com.deadline_tech.flexyboxbeta D/Nazim: Second Task12
2012-01-01 12:41:21.595 4049-4112/com.deadline_tech.flexyboxbeta D/Nazim: First Task12
2012-01-01 12:41:21.691 4049-4110/com.deadline_tech.flexyboxbeta D/Nazim: Second Task13
2012-01-01 12:41:21.695 4049-4112/com.deadline_tech.flexyboxbeta D/Nazim: First Task13
2012-01-01 12:41:21.792 4049-4110/com.deadline_tech.flexyboxbeta D/Nazim: Second Task14
2012-01-01 12:41:21.795 4049-4112/com.deadline_tech.flexyboxbeta D/Nazim: First Task14
2012-01-01 12:41:21.892 4049-4110/com.deadline_tech.flexyboxbeta D/Nazim: Second Task15
2012-01-01 12:41:21.896 4049-4112/com.deadline_tech.flexyboxbeta D/Nazim: First Task15
2012-01-01 12:41:21.992 4049-4110/com.deadline_tech.flexyboxbeta D/Nazim: Second Task16
2012-01-01 12:41:21.996 4049-4112/com.deadline_tech.flexyboxbeta D/Nazim: First Task16
2012-01-01 12:41:22.093 4049-4110/com.deadline_tech.flexyboxbeta D/Nazim: Second Task17
2012-01-01 12:41:22.096 4049-4112/com.deadline_tech.flexyboxbeta D/Nazim: First Task17
2012-01-01 12:41:22.193 4049-4110/com.deadline_tech.flexyboxbeta D/Nazim: Second Task18
2012-01-01 12:41:22.197 4049-4112/com.deadline_tech.flexyboxbeta D/Nazim: First Task18
2012-01-01 12:41:22.293 4049-4110/com.deadline_tech.flexyboxbeta D/Nazim: Second Task19
2012-01-01 12:41:22.297 4049-4112/com.deadline_tech.flexyboxbeta D/Nazim: First Task19
2012-01-01 12:41:22.394 4049-4049/com.deadline_tech.flexyboxbeta D/Nazim: Second Task finished
2012-01-01 12:41:22.397 4049-4049/com.deadline_tech.flexyboxbeta D/Nazim: First Task finished
*/
