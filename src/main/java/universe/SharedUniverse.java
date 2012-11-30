package universe;

import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Tuple3d;
import javax.vecmath.Vector3d;

import app.CanvasLoader;

import com.sun.j3d.utils.universe.SimpleUniverse;

public class SharedUniverse extends SimpleUniverse {

	private TransformGroup transCamera;

	public SharedUniverse(TransformGroup transCamera) {
		super();
		this.transCamera = transCamera;
	}

	public SharedUniverse(CanvasLoader canvas) {
		super(canvas);
		transCamera = canvas.getVpTrans();
	}

	/**
	 * Deplacement vers un point absolu de l'univers
	 * @param x
	 * @param y
	 * @param z
	 */
	public void cameraMoveTo(int x, int y, int z) {
		Transform3D t3D = new Transform3D();
		
		// setTranslation est absolu a l'univers
		t3D.setTranslation(new Vector3d(x, y, z));
	}

}
