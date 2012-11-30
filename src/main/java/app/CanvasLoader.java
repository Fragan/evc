package app;

import java.awt.Canvas;

import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.VirtualUniverse;
import javax.vecmath.Point3d;

import loader.GenericVrmlLoader;
import universe.SharedUniverse;

import com.sun.j3d.utils.behaviors.keyboard.KeyNavigatorBehavior;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class CanvasLoader extends Canvas3D {

	private GenericVrmlLoader gvl;
	private VirtualUniverse universe;
	private TransformGroup vpTrans;
	
	public CanvasLoader() {
		super(SimpleUniverse.getPreferredConfiguration());
		
		gvl = new GenericVrmlLoader("samples/colorcube2.wrl");
		BranchGroup scene = gvl.createSceneGraph();
		

		
		

		
		
		universe = new SharedUniverse(this);
		((SharedUniverse) universe).getViewingPlatform().setNominalViewingTransform();
		
//		enableInteraction(scene, canvas);
		
		// creation d'un navigateur
		vpTrans = ((SharedUniverse) universe).getViewingPlatform().getViewPlatformTransform(); // noeud camera
		try {
		vpTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		}
		catch(Exception e) {}
		
		KeyNavigatorBehavior keyNavBeh = new KeyNavigatorBehavior(vpTrans);
		keyNavBeh.setSchedulingBounds(new BoundingSphere(new Point3d(), 1000.0));
		scene.addChild(keyNavBeh);

		
		scene.compile();
		((SharedUniverse) universe).addBranchGraph(scene);
		
	
	}
	
	
	public TransformGroup getVpTrans() {
		return vpTrans;
	}
	
}
