/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.cir_frontend.controllers.http;

import java.io.Serializable;

/**
 *
 * @author Isaura
 */
public class ResponseBodyDefault implements Serializable
{
    public Object headers;
    public Object body;
    public int statusCodeValue;
    public String statusCode;
}
