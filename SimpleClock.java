//package SimpleClock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class SimpleClock extends JFrame {
    
        Calendar calendar;
        SimpleDateFormat timeFormat;
        SimpleDateFormat dayFormat;
        SimpleDateFormat dateFormat;
    
        JLabel timeLabel;
        JLabel dayLabel;
        JLabel dateLabel;
        String time;
        String day;
        String date;

        JButton set1224;
        JButton gMTButton;

        SimpleClock() {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Digital Clock");
            this.setLayout(new FlowLayout());
            this.setSize(350, 220);
            this.setResizable(false);


          gMTButton = new JButton("GMT");
            gMTButton.setBounds(50,150,100,30);
            set1224 = new JButton("12/24");
            set1224.setBounds(50,150,100,30);
           timeFormat = new SimpleDateFormat("hh:mm:ss a");
            dayFormat=new SimpleDateFormat("EEEE");
            dateFormat=new SimpleDateFormat("MMMMM dd, yyyy");
            timeLabel = new JLabel();
            timeLabel.setFont(new Font("SANS_SERIF", Font.PLAIN, 59));
            timeLabel.setBackground(Color.BLACK);
            timeLabel.setForeground(Color.GREEN);
            timeLabel.setOpaque(true);
            dayLabel=new JLabel();
            dayLabel.setFont(new Font("Ink Free",Font.BOLD,34));
    
            dateLabel=new JLabel();
            dateLabel.setFont(new Font("Ink Free",Font.BOLD,30));





        set1224.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (timeFormat.toPattern().equals("hh:mm:ss a")) {
                    timeFormat = new SimpleDateFormat("HH:mm:ss");
                } else {
                    timeFormat = new SimpleDateFormat("hh:mm:ss a");
                }
            }
        });

            this.add(gMTButton);
            this.add(set1224);
            this.add(timeLabel);
            this.add(dayLabel);
            this.add(dateLabel);
            this.setVisible(true);

            setTimer();
        }




    public void setTimer() {
        Thread timerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    time = timeFormat.format(Calendar.getInstance().getTime());
                    timeLabel.setText(time);

                    day = dayFormat.format(Calendar.getInstance().getTime());
                    dayLabel.setText(day);

                    date = dateFormat.format(Calendar.getInstance().getTime());
                    dateLabel.setText(date);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        timerThread.start();
    }
        public static void main(String[] args) {
            new SimpleClock();
        }
    }
