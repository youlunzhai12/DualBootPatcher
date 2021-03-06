// automatically generated, do not modify

package mbtool.daemon.v3;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class SignedExecRequest extends Table {
  public static SignedExecRequest getRootAsSignedExecRequest(ByteBuffer _bb) { return getRootAsSignedExecRequest(_bb, new SignedExecRequest()); }
  public static SignedExecRequest getRootAsSignedExecRequest(ByteBuffer _bb, SignedExecRequest obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public SignedExecRequest __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }

  public String binaryPath() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer binaryPathAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public String signaturePath() { int o = __offset(6); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer signaturePathAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  public String args(int j) { int o = __offset(8); return o != 0 ? __string(__vector(o) + j * 4) : null; }
  public int argsLength() { int o = __offset(8); return o != 0 ? __vector_len(o) : 0; }
  public String arg0() { int o = __offset(10); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer arg0AsByteBuffer() { return __vector_as_bytebuffer(10, 1); }

  public static int createSignedExecRequest(FlatBufferBuilder builder,
      int binary_pathOffset,
      int signature_pathOffset,
      int argsOffset,
      int arg0Offset) {
    builder.startObject(4);
    SignedExecRequest.addArg0(builder, arg0Offset);
    SignedExecRequest.addArgs(builder, argsOffset);
    SignedExecRequest.addSignaturePath(builder, signature_pathOffset);
    SignedExecRequest.addBinaryPath(builder, binary_pathOffset);
    return SignedExecRequest.endSignedExecRequest(builder);
  }

  public static void startSignedExecRequest(FlatBufferBuilder builder) { builder.startObject(4); }
  public static void addBinaryPath(FlatBufferBuilder builder, int binaryPathOffset) { builder.addOffset(0, binaryPathOffset, 0); }
  public static void addSignaturePath(FlatBufferBuilder builder, int signaturePathOffset) { builder.addOffset(1, signaturePathOffset, 0); }
  public static void addArgs(FlatBufferBuilder builder, int argsOffset) { builder.addOffset(2, argsOffset, 0); }
  public static int createArgsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startArgsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addArg0(FlatBufferBuilder builder, int arg0Offset) { builder.addOffset(3, arg0Offset, 0); }
  public static int endSignedExecRequest(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
};

