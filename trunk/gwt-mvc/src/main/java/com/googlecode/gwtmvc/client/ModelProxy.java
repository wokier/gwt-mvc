package com.googlecode.gwtmvc.client;
/**
 * Represent a data (or a collection of data) on the client side.
 * 
 * USAGE: Your model should have his own methods to load his datas by a RPC
 * call, and then call update method.
 * 
 * @param <T>
 *            data type
 */
public abstract class ModelProxy<T> extends Model<T> {

}
