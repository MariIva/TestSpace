package com.example.testspace;


public class Test {
    public String name;
    public Question questions[];

    public Test() {
        this.name = "Космос";
        this.questions = new Question[3];
        this.questions[0] = new Question("Падающие звезды – это что?", new String[]{"Метеоры", "Спутники"}, 1);
        this.questions[1] = new Question("Что придает поверхности Марса красный цвет?", new String[]{"Медь", "Никель", "Железо", "Свинец"}, 3);
        this.questions[2] = new Question("Как называется место, где используются телескопы и другое научное оборудование для исследования космоса?", new String[]{"Океанариум", "Обсерватория", "Оранжерея"}, 2);
    }
}
class Question {
    public String text;
    public String answer[];
    public int isTrue;

    public Question(String text, String answer[], int isTrue){
        this.text = text;
        this.answer = answer;
        this.isTrue = isTrue;
    }
}
