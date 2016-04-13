package com.serv.bdt;


import java.io.Serializable;

/**
 * 
 */
public class PersonSimpleBDT implements Serializable{
	/** @see Serializable **/
	private static final long serialVersionUID = 2749836172949845259L;
	
	private String address;
	private String town;
	private String country;
	private String firstName;
	private Long id;
	private String lastName;
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.address == null) ? 0 : this.address.hashCode());
		result = prime * result + ((this.country == null) ? 0 : this.country.hashCode());
		result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
		result = prime * result + ((this.town == null) ? 0 : this.town.hashCode());
		return result;
	}
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals( Object obj ){
		if( this == obj ){
			return true;
		}
		if( obj == null ){
			return false;
		}
		if( !(obj instanceof PersonSimpleBDT) ){
			return false;
		}
		PersonSimpleBDT other = (PersonSimpleBDT) obj;
		if( this.address == null ){
			if( other.address != null ){
				return false;
			}
		}
		else if( !this.address.equals( other.address ) ){
			return false;
		}
		if( this.country == null ){
			if( other.country != null ){
				return false;
			}
		}
		else if( !this.country.equals( other.country ) ){
			return false;
		}
		if( this.firstName == null ){
			if( other.firstName != null ){
				return false;
			}
		}
		else if( !this.firstName.equals( other.firstName ) ){
			return false;
		}
		if( this.id == null ){
			if( other.id != null ){
				return false;
			}
		}
		else if( !this.id.equals( other.id ) ){
			return false;
		}
		if( this.lastName == null ){
			if( other.lastName != null ){
				return false;
			}
		}
		else if( !this.lastName.equals( other.lastName ) ){
			return false;
		}
		if( this.town == null ){
			if( other.town != null ){
				return false;
			}
		}
		else if( !this.town.equals( other.town ) ){
			return false;
		}
		return true;
	}

	/**
	 * @return the address
	 */
	public String getAddress(){
		return this.address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress( String address ){
		this.address = address;
	}

	/**
	 * @return the town
	 */
	public String getTown(){
		return this.town;
	}

	/**
	 * @param town the town to set
	 */
	public void setTown( String town ){
		this.town = town;
	}

	/**
	 * @return the country
	 */
	public String getCountry(){
		return this.country;
	}

	/**
	 * @param city the country to set
	 */
	public void setCountry( String country ){
		this.country = country;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName(){
		return this.firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName( String firstName ){
		this.firstName = firstName;
	}

	/**
	 * @return the id
	 */
	public Long getId(){
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId( Long id ){
		this.id = id;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName(){
		return this.lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName( String lastName ){
		this.lastName = lastName;
	}
}
