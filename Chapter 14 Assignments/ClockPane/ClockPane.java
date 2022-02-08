import java.util.Calendar; 
import java.util.GregorianCalendar;
// import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


public class ClockPane extends Pane {
  private int hour;
  private int minute;
  private int second;
  private boolean hourHandVisible;
  private boolean minuteHandVisible;
  private boolean secondHandVisible;
  
  
  /** Construct a default clock with the current time*/
  public ClockPane() {
    setCurrentTime();
  }

  /** Construct a clock with specified hour, minute, and second */
  public ClockPane(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  /** Return hour */
  public int getHour() {
    return hour;
  }

  /** Set a new hour */
  public void setHour(int hour) {
    this.hour = hour;
    paintClock();
  }

  /** Return minute */
  public int getMinute() {
    return minute;
  }

  /** Set a new minute */
  public void setMinute(int minute) {
    this.minute = minute;
    paintClock();
  }

  /** Return second */
  public int getSecond() {
    return second;
  }

  /** Set a new second */
  public void setSecond(int second) {
    this.second = second;
    paintClock();
  }
  
  public boolean getHourHandVisible() {
	  return this.hourHandVisible;
  }
  
  public void setHourHandVisible(boolean bool) {
	  this.hourHandVisible = bool;
  }
  
  public boolean getMinuteHandVisible() {
	  return this.minuteHandVisible;
  }
  
  public void setMinuteHandVisible(boolean bool) {
	  this.minuteHandVisible = bool;
  }
  
  public boolean getSecondHandVisible() {
	  return this.secondHandVisible;
  }
  
  public void setSecondHandVisible(boolean bool) {
	  this.secondHandVisible = bool;
  }
  
  /* Set the current time for the clock */
  public void setCurrentTime() {
    // Construct a calendar for the current date and time
    Calendar calendar = new GregorianCalendar();

    // Set current hour, minute and second
    // this.hour = calendar.get(Calendar.HOUR_OF_DAY);
    // this.minute = calendar.get(Calendar.MINUTE);
    // this.second = calendar.get(Calendar.SECOND);
    this.hour = (int)(Math.random()*12);
    System.out.println("Hour: " + this.hour);
    this.minute = (int)(Math.random()*2);
    if(this.minute == 1)
    	this.minute = 30;
    System.out.println("Minute: " + this.minute);
    this.hourHandVisible = true;
    this.minuteHandVisible = true;
    this.secondHandVisible = false;
    paintClock(); // Repaint the clock
  }
  
  /** Paint the clock */
  private void paintClock() {
    // Initialize clock parameters
    double clockRadius = 
      Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
    double centerX = getWidth() / 2;
    double centerY = getHeight() / 2;

    // Draw circle
    Circle circle = new Circle(centerX, centerY, clockRadius);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);
    Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
    Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
    Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
    Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
    
    
    // Draw second hand
    double sLength = clockRadius * 0.8;
    double secondX = centerX + sLength * 
      Math.sin(second * (2 * Math.PI / 60));
    double secondY = centerY - sLength * 
      Math.cos(second * (2 * Math.PI / 60));
    Line sLine = new Line(centerX, centerY, secondX, secondY);
    sLine.setStroke(Color.RED);
    if(!this.secondHandVisible) {
    	sLine.setStartX(0);
    	sLine.setStartY(0);
    	sLine.setEndX(0);
    	sLine.setEndY(0);
    }
    
    

    // Draw minute hand
    double mLength = clockRadius * 0.65;
    double xMinute = centerX + mLength * 
      Math.sin(minute * (2 * Math.PI / 60));
    double minuteY = centerY - mLength * 
      Math.cos(minute * (2 * Math.PI / 60));
    Line mLine = new Line(centerX, centerY, xMinute, minuteY);
    mLine.setStroke(Color.BLUE);
    if(!this.minuteHandVisible) {
    	mLine.setStartX(0);
    	mLine.setStartY(0);
    	mLine.setEndX(0);
    	mLine.setEndY(0);
    }
    
    // Draw hour hand
    double hLength = clockRadius * 0.5;
    double hourX = centerX + hLength * 
      Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    double hourY = centerY - hLength *
      Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    Line hLine = new Line(centerX, centerY, hourX, hourY);
    hLine.setStroke(Color.GREEN);
    if(!this.hourHandVisible) {
    	hLine.setStartX(0);
    	hLine.setStartY(0);
    	hLine.setEndX(0);
    	hLine.setEndY(0);
    }
    
    getChildren().clear();  
    getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
  }
  
  @Override
  public void setWidth(double width) {
    super.setWidth(width);
    paintClock();
  }
  
  @Override
  public void setHeight(double height) {
    super.setHeight(height);
    paintClock();
  }
  
}
