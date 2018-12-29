import java.awt.*;
class Body
{
    Vector position, velocity; Color color;
    double mass=0;
    Body(Vector position, Vector velocity, double mass, Color color)
    {
        this.position=position;
        this.velocity=velocity;
        this.mass=mass;
        this.color=color;
    }
    
    void update(Vector gravity)
    {
        Vector acceleration=new Vector(gravity.x/mass,gravity.y/mass);
        position.add(velocity);
        velocity.add(acceleration);
    }
}