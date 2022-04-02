package gamers;

import java.util.Random;

import main.Pair;
import main.Unit;

public class S26286 extends Unit {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1282037319880776133L;

	public S26286(final String id, final Pair<Double, Double> position, final double rotate,
			final CollisionModel model) {
		super(id, position, rotate, model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.enableStopOnWall();
		this.enableMovement();

		int counter = 0;
		int stepsAfterForcedRotation = 0;

		this.forward();
		this.setSpeed(100);
		final int deg = 20;
		final Random rand = new Random();
		final int minRandomDeg = -30;
		final int maxRandomDeg = 30;

		while (true) {
			counter = (counter + 1) % 2000;
			stepsAfterForcedRotation = stepsAfterForcedRotation + 1;

			if (this.nearestCollision() <= 2 && nearestCollision() >= 0) {
				this.rotateBy(deg);
				stepsAfterForcedRotation = 0;
			} else {
				if (counter == 0 && stepsAfterForcedRotation > 100) {
					final int randomDeg = rand.nextInt(minRandomDeg, maxRandomDeg);
					System.out.println("randomdeg  " + randomDeg);
					this.rotateBy(randomDeg);
				}
			}

			if (this.whatIsInRange() >= 3) {
				this.stopRotate();
				this.attackInNextMove();
			}
			if (this.nearestCollision() == 0) {
				this.rotateBy(90);
			}

		}

	}

}
