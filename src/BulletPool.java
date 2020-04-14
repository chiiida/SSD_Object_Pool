import java.util.ArrayList;
import java.util.List;

public class BulletPool {

    private static BulletPool instance;
    private List<Bullet> bullets;

    private BulletPool() {
        bullets = new ArrayList<Bullet>();
        for (int i = 0; i < 10; i++) {
            bullets.add(new Bullet(0,0,0,0));
        }
    }

    public static BulletPool getInstance() {
        if (instance == null) {
            instance = new BulletPool();
        }
        return instance;
    }

    public Bullet acquireBullet(int x, int y, int dX, int dY) {
        // for the case that no bullet
        if (bullets.isEmpty()) {
            for (int i = 0; i < 10; i++) {
                bullets.add(new Bullet(0,0,0,0));
            }
        }

        Bullet bullet = bullets.remove(bullets.size() - 1);
        bullet.setX(x);
        bullet.setY(y);
        bullet.setDx(dX);
        bullet.setDy(dY);

        return bullet;
    }

    public void releaseBullet(Bullet b) {
        bullets.add(b);
    }
}
