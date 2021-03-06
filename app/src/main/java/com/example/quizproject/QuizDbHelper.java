package com.example.quizproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;

import com.example.quizproject.QuizContract.*;

import java.util.ArrayList;
import java.util.List;


public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "QuizProject.db";
    private static final int DATABASE_VERSION = 9;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        //Creating first table
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

//Creating second table
        final String SQL_CREATE_QUESTIONS_TABLE2 = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME2 + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";
//Creating third table
        final String SQL_CREATE_QUESTIONS_TABLE3 = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME3 + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

//Creating forth table
        final String SQL_CREATE_QUESTIONS_TABLE4 = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME4 + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";
//Creating 5th table
        final String SQL_CREATE_QUESTIONS_TABLE5 = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME5 + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        //Creating 6th table
        final String SQL_CREATE_QUESTIONS_TABLE6 = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME6 + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE2);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE3);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE4);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE5);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE6);
        fillQuestionsTable();
        fillQuestionsTable2();
        fillQuestionsTable3();
        fillQuestionsTable4();
        fillQuestionsTable5();
        fillQuestionsTable6();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME4);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME5);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME6);

        onCreate(db);
    }


    //FOR TABLE 1
    private void fillQuestionsTable() {
        Question q1 = new Question("What is the color of Donald Duck’s bowtie?","Red","Yellow","Blue",1);
        addQuestion(q1);
        Question q2 = new Question("Which animal does not appear in the Chinese zodiac?","Dragon","Rabbit","Hummingbird",3);
        addQuestion(q2);
        Question q3 = new Question("Which country held the 2016 Summer Olympics?","Brazil","China","Ireland",1);
        addQuestion(q3);
        Question q4 = new Question("Which planet is the hottest?","Venus","Mercury","Saturn",1);
        addQuestion(q4);
        Question q5 = new Question("What does the “D” in “D-Day” stand for?","Dooms","Dick? :D","Denmark",3);
        addQuestion(q5);
        Question q6 = new Question("In Pirates of the Caribbean, what was the name of Captain Jack Sparrow’s ship?","The Marauder","The Black Pearl","The Black Python",2);
        addQuestion(q6);
        Question q7 = new Question("According to Forrest Gump, “life was like…”","A bag of lemons","Buzz lightyear!","A box of chocolates",3);
        addQuestion(q7);
        Question q8 = new Question("What is the rarest blood type?","O","AB-Negative","A",2);
        addQuestion(q8);
        Question q9 = new Question("Which one of these characters aren’t a part of the Friends group?","Joey","Chandler","Gunther\n'What a Simp!!'",3);
        addQuestion(q9);
        Question q10 = new Question("How many bones are there in the human body?","206","106","201",1);
        addQuestion(q10);

    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }


    //FOR TABLE 2
    private void fillQuestionsTable2() {
        Question m10 = new Question("Ok what kind of idiot chooses maths category ?", "Stupid", "Very stupid", "Booring nerd!", 3);
        addQuestion2(m10);
        Question m1 = new Question("'PS. Fine enjoy these booring question while i chill in GOT section!'\nThe average of first 50 natural numbers is ?", "25.30", "25.5", "25.00", 2);
        addQuestion2(m1);
        Question m2 = new Question("15/5+27", "Non of the below", "5", "30", 3);
        addQuestion2(m2);
        Question m3 = new Question("The number of 3-digit numbers divisible by 6, is?", "149", "166", "150", 3);
        addQuestion2(m3);
        Question m4 = new Question("106 × 106 – 94 × 94 = ?", "2004", "2400", "1904", 1);
        addQuestion2(m4);
        Question m5 = new Question("What is 1004 divided by 2?", " 52", "502", "520", 2);
        addQuestion2(m5);
        Question m6 = new Question("Which of the following numbers gives 240 when added to its own square?", "15", "16", "18", 1);
        addQuestion2(m6);
        Question m7 = new Question("83 × 82 × 8-5 is", "8", "1", "None of these", 3);
        addQuestion2(m7);
        Question m8 = new Question("The simplest form of 1.5 : 2.5 is", "6 : 10", "0.75 : 1.25", "3 : 5", 3);
        addQuestion2(m8);
        Question m9 = new Question("In 24,673 ; the place-value of 6 is ?  'PS. Choose more fun category next time!'", "600", "10", "100", 1);
        addQuestion2(m9);

    }

    private void addQuestion2(Question question) {

        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME2, null, cv);
    }

    public List<Question> getAllQuestions2() {
        List<Question> questionList = new ArrayList<>();
        db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME2, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }


    //FOR TABLE 3
    private void fillQuestionsTable3() {
        Question h1 = new Question("Who is Harry Potter’s godfather? ", "Sirius Black", "Remus lupin", "Albus Dumbledore", 1);
        addQuestion3(h1);
        Question m2 = new Question("What year was the first film, Harry Potter and the Philosopher’s Stone, released in cinemas?", "2003", "2002", "2001", 3);
        addQuestion3(m2);
        Question m3 = new Question("What is the name of Harry’s mother? ", "Petunia Potter", "Lily Potter", "Belatrix Potter", 2);
        addQuestion3(m3);
        Question m4 = new Question("Which class has a different teacher every year? ", "DADA", "Potions", "Transfiguration", 1);
        addQuestion3(m4);
        Question m5 = new Question("Who did Game of Thrones actress Natalia Tena play in the Harry Potter films? ", "Petunia Dursley", "Nymphadora Tonks", "Lily", 2);
        addQuestion3(m5);
        Question m6 = new Question("What is the name of Voldermort’s pet snake? ", "Salazar", "Nagini", "Buckbeak", 2);
        addQuestion3(m6);
        Question m7 = new Question("Who was Hermione’s date at the Yule Ball? ", "Harry potter", "Bill Weasley", "Viktor Krum", 3);
        addQuestion3(m7);
        Question m8 = new Question("What is the name of the building said to be the most haunted in Britain? ", "Whomping Willow", "Hogsmeade", "Shrieking Shack", 3);
        addQuestion3(m8);
        Question m9 = new Question("On which floor of Hogwarts was the forbidden corridor in The Philosopher’s Stone?", "3rd", "7th", "5th", 2);
        addQuestion3(m9);
        Question m10 = new Question("What animal represents Hufflepuff house?", "Rabbit", "Snake", "Badger", 3);
        addQuestion3(m10);

    }

    private void addQuestion3(Question question) {

        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME3, null, cv);
    }

    public List<Question> getAllQuestions3() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME3, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    //FOR TABLE 4
    private void fillQuestionsTable4() {
        Question h1 = new Question("How many episodes of Game of Thrones are there in total? ", "80\n'IDK bitch who counted!'", "75\n'75 rounds up nice'", "73\n'What a odd number'", 3);
        addQuestion4(h1);
        Question m2 = new Question("Which character appears in more episodes than any other?", "Tyrion Lannister\n'I like this guy'", "Jon Snow\n'Dumbass never know anything'", "Cersei lannister\n'This bitch was everywhere'", 1);
        addQuestion4(m2);
        Question m3 = new Question("Which animal does Tywin Lannister skin during his first appearance in the show? ", "Rabbit", "Deer", " Wolf\n'Not cool bro they are awesome! '", 2);
        addQuestion4(m3);
        Question m4 = new Question("All men must die’ translates as what term in High Valyrian? ", "Winter is comming. \n'OMG you need to stop saying that for 100th time' ", "Valar dohaeris \n'IDK maybe me' ", "Valar morghulis \n'or me' ", 3);
        addQuestion4(m4);
        Question m5 = new Question("What is the name of Jon Snow’s direwolf?", "Lady", "Ghost", "Grey Wind \n'ok this is a cool name'", 2);
        addQuestion4(m5);
        Question m6 = new Question("Which character says the line: “Say it. Say her name. Say it!” ", "Oberyn Martell \n'Damn that headpop scene though'", "Little finger \n'Someone kill this guy already!'", "Tyrion Lannister", 1);
        addQuestion4(m6);
        Question m7 = new Question("What is the name of the huge mercenary army commanded by Daenerys? ", "Ones without Dicks :D", "Golden company", "The Unsullied\n'No dicks in medieval age bro that sucks'", 3);
        addQuestion4(m7);
        Question m8 = new Question("How does Viserys Targaryen die in season 1? ", "Khal kisses him to death!\n'Ok this should have been the scene'", "Khal rips his head off", "Khal Drogo pours liquid gold over his head", 3);
        addQuestion4(m8);
        Question m9 = new Question("Which character is often referred to with ‘Giantsbane’ in their name? ", "Tyrion Lannister \n'Obviously'", "Little Finger", "Tormund", 3);
        addQuestion4(m9);
        Question m10 = new Question("Which character ends up being crowned King of the Six Kingdoms in the final episode? ", "John Snow\n'PS. Incest is not cool bro' ", "Sam \n'lol that would have been funny' ", "Bran Stark\n'Come on smile a little'", 3);
        addQuestion4(m10);

    }

    private void addQuestion4(Question question) {

        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME4, null, cv);
    }

    public List<Question> getAllQuestions4() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME4, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    //FOR TABLE 5
    private void fillQuestionsTable5() {
        Question h1 = new Question("What is the title of the Italian protest song which is played throughout the series?","Bella ciao","Waka Waka","Macarena",1);
        addQuestion5(h1);
        Question m2 = new Question("How much money did the gang manage to steal from the Royal Mint of Spain?","€2.1 billion","€2.4 billion","€2.7 billion",2);
        addQuestion5(m2);
        Question m3 = new Question("What is Tokyo's real name in the series?","Alba Flores.","Úrsula Corberó","Silene Oliveira",3);
        addQuestion5(m3);
        Question m4 = new Question("Who instructed Denver to dispose of hostage Mónica?","Berlin","Professor","Helsinki",1);
        addQuestion5(m4);
        Question m5 = new Question("What name does The Professor use as a false identity during the Royal Mint robbery?","James Bond?","Salvador 'Salva' Martín","Heisenberg",2);
        addQuestion5(m5);
        Question m6 = new Question("What was Lisbon's name before she was given her alias?","Tokyo","Silene Oliveira","Raquel Murillo",3);
        addQuestion5(m6);
        Question m7 = new Question(" In which part of the body does Manila shoot Arturo?","Eyes","The leg","Arm",2);
        addQuestion5(m7);
        Question m8 = new Question("Which country does Helsinki originally come from?","Itali","Serbia","Romania",2);
        addQuestion5(m8);
        Question m9 = new Question("How many robberies did Berlin say he committed as a jewellery thief?","20","25","27",3);
        addQuestion5(m9);
        Question m10 = new Question("How did Moscow die?","Shot by police","Suicide","Fell to his death",1);
        addQuestion5(m10);

    }

    private void addQuestion5(Question question) {

        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME5, null, cv);
    }

    public List<Question> getAllQuestions5() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME5, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    //FOR TABLE 6
    private void fillQuestionsTable6() {
        Question h1 = new Question("Who is Itachi's sidekick/teammate?","Kisame","Sasuke","Orochimaru",1);
        addQuestion6(h1);
        Question m2 = new Question("What is Shino's last name?","Akimichi","Aburame","Uzumaki",2);
        addQuestion6(m2);
        Question m3 = new Question("Who killed the 3rd Hokage?","Gaara","1st and 2nd Hokage","Orochimaru",3);
        addQuestion6(m3);
        Question m4 = new Question("Who likes Naruto?","Sakura","Tenten","Hinata",3);
        addQuestion6(m4);
        Question m5 = new Question("Who likes Sasuke?","Ino and Sakura","Tenten","Hinata",1);
        addQuestion6(m5);
        Question m6 = new Question("Who are the 3 people who could use the Sharingan?","Neji, Hinata, and Kakashi","Jiraiya, Tsundae, and Orochimaru","Itachi, Sasuke, and Kakashi",3);
        addQuestion6(m6);
        Question m7 = new Question("Why does Sasuke want to kill his brother?","Because his brother killed the Uchiha clan except for him","Because he voted for Trump","Because he spoiled GOT",1);
        addQuestion6(m7);
        Question m8 = new Question("What is Team 7's 1st enemy. Hint: he was a Jounin and called The Demon Hidden in the Mist.","Orochimaru","Zabuza","Haku",2);
        addQuestion6(m8);
        Question m9 = new Question("What are the members of Team 10?","Ino, Chouji, Shikamaru, and Asuma","Neji, Lee, Tenten, and Guy","Hinata, Shino, Kiba, and Kurenai",1);
        addQuestion6(m9);
        Question m10 = new Question("What are the 2 other members of Kabuto's team during the Chuunin exams?","Orochimaru and Anko","Misumi and Yoroi","Sasuke and Naruto",2);
        addQuestion6(m10);

    }

    private void addQuestion6(Question question) {

        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME6, null, cv);
    }

    public List<Question> getAllQuestions6() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME6, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }


}