package com.example.test;

import java.lang.Thread;
import java.net.*;
public class sender2 extends Thread{
	DatagramSocket socket=null;
	boolean state=false;
	byte[] data="yttyty".getBytes();
	public sender2(String s){
		data=s.getBytes();
		try{
		socket = new DatagramSocket();
		}
		catch(Exception e)
		{
			System.out.println(""+e);
		}
	}
	public void setData(byte[] s)
	{
		System.out.println("data");
		data=s;
	}
	public void send(boolean a){
		state=a;

	}
	public void run(){
				System.out.println("send started");
				try{
					System.out.println("packet send1");
					//data ="This is the message".getBytes();
					DatagramPacket packet =new DatagramPacket(data, data.length);
					System.out.println("packet send2");
					InetAddress destAddress =InetAddress.getByName("192.168.0.255");
					System.out.println("packet send3");
					packet.setAddress(destAddress);
					System.out.println("packet send4");
					packet.setPort(4444);
					System.out.println("packet send5");
					socket.send(packet);
					state=false;
					System.out.println("packet send6");
			
				}
				catch(Exception e)
				{
					System.out.println("qweqwe"+e);
				}
		
			socket.close();
	}
}
