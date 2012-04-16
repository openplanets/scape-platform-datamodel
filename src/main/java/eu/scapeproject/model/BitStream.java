package eu.scapeproject.model;

public class BitStream {
    public enum Type{
        STREAM;
    }
    private String title;
    private Type type;
    private long offset;
    private long size;
}
