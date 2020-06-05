import greenfoot.*;

/**
 * A bullet that can hit asteroids.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 */
public class Poison extends SmoothMover
{
    /** The damage this bullet will deal */
    private static final int damage = 16;
    
    /** A bullet looses one life each act, and will disappear when life = 0 */
    private int life = 30;
    
    private final static int pointsToAdd = 10;
    
    /**
     * Default constructor for testing.
     */
    public Poison()
    {
    }
    
    /**
     * Create a bullet with given speed and direction of movement.
     */
    public Poison(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        addToVelocity(new Vector(rotation, 15));
        Greenfoot.playSound("EnergyGun.wav");
    }
    
    /**
     * The bullet will damage asteroids if it hits them.
     */
    public void act()
    {
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else {
            life--;
            move();
            checkAsteroidHit();
        }
    }
    
    /**
     * Check whether we have hit an asteroid.
     */
    private void checkAsteroidHit()
    {
        Snake asteroid = (Snake) getOneIntersectingObject(Snake.class);
        if (asteroid != null)
        {
            ((Desert) getWorld()).updateScore(pointsToAdd);
            getWorld().removeObject(this);
            asteroid.hit(damage);
        }
    }

}