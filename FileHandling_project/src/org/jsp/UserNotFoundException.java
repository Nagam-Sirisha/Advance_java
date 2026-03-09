package org.jsp;

public class UserNotFoundException  extends RuntimeException
{
	public UserNotFoundException(String reason)
	{
		super(reason);
	}
}
