package com.example;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ClockFrame extends JFrame {

  SimpleDateFormat timeFormat;
  SimpleDateFormat dayFormat;
  SimpleDateFormat dateFormat;
  JLabel timeLabel;
  JLabel dayLabel;
  JLabel dateLabel;
  String time;
  String day;
  String date;

  ClockFrame() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("My Clock Program");
    this.setLayout(new FlowLayout());
    this.setSize(350, 300);
    this.setBackground(Color.blue);
    //this.setResizable(false);

    timeFormat = new SimpleDateFormat("HH:mm:ss");
    dayFormat = new SimpleDateFormat("EEEE");
    dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
    timeLabel = new JLabel();
    timeLabel.setFont(new Font("Verdena",Font.PLAIN, 70));
    timeLabel.setForeground(new Color(0x00FF00));
    timeLabel.setBackground(Color.blue);
    timeLabel.setOpaque(true);

    dayLabel = new JLabel();
    dayLabel.setFont(new Font("Ink Free",Font.PLAIN, 50));
    dayLabel.setForeground(new Color(0x00FF00));
    dayLabel.setBackground(Color.blue);
    dayLabel.setOpaque(true);

    dateLabel = new JLabel();
    dateLabel.setFont(new Font("Verdena",Font.PLAIN, 50));
    dateLabel.setForeground(new Color(0x00FF00));
    dateLabel.setBackground(Color.blue);
    dateLabel.setOpaque(true);

    this.add(timeLabel);
    this.add(dayLabel);
    this.add(dateLabel);
    this.setVisible(true);

    setTime();
  }

  public void setTime() {
    while(true){
      Date timelong = Calendar.getInstance().getTime();
      time = timeFormat.format(timelong);
      timeLabel.setText(time);
      day = dayFormat.format(timelong);
      dayLabel.setText(day);
      date = dateFormat.format(timelong);
      dateLabel.setText(date);
      try {
        Thread.sleep(1000);
      }catch(InterruptedException e){
        // Do nothing
      }
    }
  }
}
