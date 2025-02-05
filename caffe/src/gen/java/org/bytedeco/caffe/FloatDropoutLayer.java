// Targeted by JavaCPP version 1.5.7: DO NOT EDIT THIS FILE

package org.bytedeco.caffe;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import org.bytedeco.opencv.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import org.bytedeco.opencv.opencv_videoio.*;
import static org.bytedeco.opencv.global.opencv_videoio.*;
import org.bytedeco.opencv.opencv_highgui.*;
import static org.bytedeco.opencv.global.opencv_highgui.*;
import org.bytedeco.hdf5.*;
import static org.bytedeco.hdf5.global.hdf5.*;

import static org.bytedeco.caffe.global.caffe.*;


/**
 * \brief During training only, sets a random portion of {@code x} to 0, adjusting
 *        the rest of the vector magnitude accordingly.
 *
 * @param bottom input Blob vector (length 1)
 *   -# {@code  (N \times C \times H \times W) }
 *      the inputs {@code  x }
 * @param top output Blob vector (length 1)
 *   -# {@code  (N \times C \times H \times W) }
 *      the computed outputs {@code  y = |x| }
 */
@Name("caffe::DropoutLayer<float>") @NoOffset @Properties(inherit = org.bytedeco.caffe.presets.caffe.class)
public class FloatDropoutLayer extends FloatNeuronLayer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FloatDropoutLayer(Pointer p) { super(p); }

  /**
   * @param param provides DropoutParameter dropout_param,
   *     with DropoutLayer options:
   *   - dropout_ratio (\b optional, default 0.5).
   *     Sets the probability {@code  p } that any given unit is dropped.
   */
  public FloatDropoutLayer(@Const @ByRef LayerParameter param) { super((Pointer)null); allocate(param); }
  private native void allocate(@Const @ByRef LayerParameter param);
  @Virtual public native void LayerSetUp(@Const @ByRef FloatBlobVector bottom,
        @Const @ByRef FloatBlobVector top);
  @Virtual public native void Reshape(@Const @ByRef FloatBlobVector bottom,
        @Const @ByRef FloatBlobVector top);

  @Virtual public native @Const({false, false, true}) @Cast("const char*") BytePointer type();
  @Virtual protected native void Forward_cpu(@Const @ByRef FloatBlobVector bottom,
        @Const @ByRef FloatBlobVector top);
  @Virtual protected native void Forward_gpu(@Const @ByRef FloatBlobVector bottom,
        @Const @ByRef FloatBlobVector top);
  @Virtual protected native void Backward_cpu(@Const @ByRef FloatBlobVector top,
        @Const @ByRef BoolVector propagate_down, @Const @ByRef FloatBlobVector bottom);
  @Virtual protected native void Backward_gpu(@Const @ByRef FloatBlobVector top,
        @Const @ByRef BoolVector propagate_down, @Const @ByRef FloatBlobVector bottom);
}
