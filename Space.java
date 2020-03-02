import greenfoot.*;

/**
 * Space. Something for rockets to fly in.
 * 
 * @author Tyler Ford
 * @version 1.1
 */
public class Space extends World
{
    private Counter scoreCounter;
    private int startAsteroids = 3;

    /**
     * Create the space and all objects within it.
     */
    public Space() 
    {
        super(600, 500, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        
        Rocket rocket = new Rocket();
        addObject(rocket, getWidth()/2 + 100, getHeight()/2);
        
        addAsteroids(startAsteroids);
        
        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 480);

        Explosion.initializeImages();
        ProtonWave.initializeImages();
        paintStars(300);
    }
    
    /**
     * Add a given number of asteroids to our world. Asteroids are only added into
     * the left half of the world.
     */
    private void addAsteroids(int count) 
    {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth()/2);
            int y = Greenfoot.getRandomNumber(getHeight()/2);
            addObject(new Asteroid(), x, y);

    }
    }
    private void paintStars(int count)
    {
    GreenfootImage background = getBackground();
    for (int i=0; i < count + 1; i++)
        {
        int x = Greenfoot.getRandomNumber ( getWidth() );
        int y = Greenfoot.getRandomNumber ( getHeight() );
        int color1 = 150 - Greenfoot.getRandomNumber (120);
        int color2 = color1 - Greenfoot.getRandomNumber (20);
        int color3 = color1 + Greenfoot.getRandomNumber (20);
        background.setColorAt(x,y, new Color(color1,color2,color3));
        int size1 = 3 - Greenfoot.getRandomNumber(2);
        int size2 = 3 - Greenfoot.getRandomNumber(2);
        background.fillOval(x, y, size1, size2);
    }
    }
    /**
     * This method is called when the game is over to display the final score.
     */
    public void gameOver() 
    {
        int x=getWidth()/2;
        int y=getHeight()/2;
        int currentScore=scoreCounter.getValue();
        addObject(new ScoreBoard(currentScore),x,y);
     
    }
    public void updateScore(int addToScore)
    {
        scoreCounter.add(addToScore);
    }
}
