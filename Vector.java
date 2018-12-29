class Vector
{
    double x=0, y=0;
    Vector(double x,double y)
    {
        this.x=x;
        this.y=y;
    }
    
    void add(Vector b)
    {
        x+=b.x;
        y+=b.y;
    }
}