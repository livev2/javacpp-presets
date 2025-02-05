// Targeted by JavaCPP version 1.5.7: DO NOT EDIT THIS FILE

package org.bytedeco.liquidfun;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.liquidfun.global.liquidfun.*;


/** A shape is used for collision detection. You can create a shape however you like.
 *  Shapes used for simulation in b2World are created automatically when a b2Fixture
 *  is created. Shapes may encapsulate a one or more child shapes. */
@Properties(inherit = org.bytedeco.liquidfun.presets.liquidfun.class)
public class b2Shape extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public b2Shape(Pointer p) { super(p); }

	
	/** enum b2Shape::Type */
	public static final int
		e_circle = 0,
		e_edge = 1,
		e_polygon = 2,
		e_chain = 3,
		e_typeCount = 4;

	/** Clone the concrete shape using the provided allocator. */
	public native b2Shape Clone(b2BlockAllocator allocator);

	/** Get the type of this shape. You can use this to down cast to the concrete shape.
	 *  @return the shape type. */
	public native @Cast("b2Shape::Type") int GetType();

	/** Get the number of child primitives. */
	public native @Cast("int32") int GetChildCount();

	/** Test a point for containment in this shape. This only works for convex shapes.
	 *  @param xf the shape world transform.
	 *  @param p a point in world coordinates. */
	public native @Cast("bool") boolean TestPoint(@Const @ByRef b2Transform xf, @Const @ByRef b2Vec2 p);

	/** Compute the distance from the current shape to the specified point. This only works for convex shapes.
	 *  @param xf the shape world transform.
	 *  @param p a point in world coordinates.
	 *  @param distance returns the distance from the current shape.
	 *  @param normal returns the direction in which the distance increases. */
	public native void ComputeDistance(@Const @ByRef b2Transform xf, @Const @ByRef b2Vec2 p, @Cast("float32*") FloatPointer distance, b2Vec2 normal, @Cast("int32") int childIndex);
	public native void ComputeDistance(@Const @ByRef b2Transform xf, @Const @ByRef b2Vec2 p, @Cast("float32*") FloatBuffer distance, b2Vec2 normal, @Cast("int32") int childIndex);
	public native void ComputeDistance(@Const @ByRef b2Transform xf, @Const @ByRef b2Vec2 p, @Cast("float32*") float[] distance, b2Vec2 normal, @Cast("int32") int childIndex);

	/** Cast a ray against a child shape.
	 *  @param output the ray-cast results.
	 *  @param input the ray-cast input parameters.
	 *  @param transform the transform to be applied to the shape.
	 *  @param childIndex the child shape index */
	public native @Cast("bool") boolean RayCast(b2RayCastOutput output, @Const @ByRef b2RayCastInput input,
							@Const @ByRef b2Transform transform, @Cast("int32") int childIndex);

	/** Given a transform, compute the associated axis aligned bounding box for a child shape.
	 *  @param aabb returns the axis aligned box.
	 *  @param xf the world transform of the shape.
	 *  @param childIndex the child shape */
	public native void ComputeAABB(b2AABB aabb, @Const @ByRef b2Transform xf, @Cast("int32") int childIndex);

	/** Compute the mass properties of this shape using its dimensions and density.
	 *  The inertia tensor is computed about the local origin.
	 *  @param massData returns the mass data for this shape.
	 *  @param density the density in kilograms per meter squared. */
	public native void ComputeMass(b2MassData massData, @Cast("float32") float density);

	public native @Cast("b2Shape::Type") int m_type(); public native b2Shape m_type(int setter);
	public native @Cast("float32") float m_radius(); public native b2Shape m_radius(float setter);
}
