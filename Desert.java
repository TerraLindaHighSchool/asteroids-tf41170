import greenfoot.*;

/**
 * Space. Something for rockets to fly in.
 * 
 * @author Tyler Ford
 * @version 1.1
 */
public class Desert extends World
{
    private Counter scoreCounter;
    private int startAsteroids = 3;

    /**
     * Create the space and all objects within it.
     */
    public Desert() 
    {
        super(600, 500, 1);
        
        Rocket rocket = new Rocket();
        addObject(rocket, getWidth()/2 + 100, getHeight()/2);
        
        addAsteroids(startAsteroids);
        
        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 480);

        Explosion.initializeImages();
        ProtonWave.initializeImages();
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
