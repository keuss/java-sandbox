package com.cgi.ldap.test;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/**
 * @author galloisg
 * 
 * </br>
 * <b>Test : savoir quand le connexion LDAP est réalisée !</b>
 *
 */
public class LdapTest {

	private String ldapUrl = "ldap://FR-WST-VM-0768:389"; //ldap://10.80.136.98:389 ou ldap://localhost:10389
	private String initialContextFactory = "com.sun.jndi.ldap.LdapCtxFactory";
	private String loginDN = "cn=root";
	private String adminPassword = "Logica";
	private String securityAuthentications = "simple";
	Hashtable<Object, Object> envValues = null;

	/**
	 * constructor
	 * @throws NamingException 
	 */
	public LdapTest() throws NamingException {
		
		envValues = new Hashtable<Object, Object>();

		envValues.put(Context.INITIAL_CONTEXT_FACTORY, initialContextFactory);
		// donne l'addresse du ldap sous la forme ldap://serveur:port
		envValues.put(Context.PROVIDER_URL, ldapUrl);
		
		// donne le mode d'authentification
		envValues.put(Context.SECURITY_AUTHENTICATION, securityAuthentications);
		// donne le dn de l'utilisateur qui va parcourir le LDAP
		envValues.put(Context.SECURITY_PRINCIPAL, loginDN); // specify the username
		// donne le password de l'utilisateur qui va parcourir le LDAP
		envValues.put(Context.SECURITY_CREDENTIALS, adminPassword);

		// use a connection pool
		envValues.put("com.sun.jndi.ldap.connect.pool", "true"); 
		
	}
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		//test pool
		System.setProperty("com.sun.jndi.ldap.connect.pool.debug", "fine");
	//	System.setProperty("com.sun.jndi.ldap.connect.pool.maxsize", "104");
		System.out.println(System.getProperty("com.sun.jndi.ldap.connect.pool.maxsize"));
		LdapTest ldapTest = null;
		try {
			ldapTest = new LdapTest();
			//ctx 1 -------------------------------------------------------------------
			System.out.println("####### connexion ... at " + System.currentTimeMillis());
			DirContext ctx1 = new InitialDirContext(ldapTest.envValues);
			System.out.println("####### connexion ok at :" + System.currentTimeMillis());
			
			//test ldapTest avec cardif
			Attributes attrs = ctx1.getAttributes("sn=p8admin,cn=cardif,O=BNPP");
			
			//test ldapTest avec ldap local
			//Attributes attrs = ctx1.getAttributes("o=CPM_SCANOPS,o=bnpp");
			System.out.println(attrs.toString());
			
			//la connexion LDAP est réalisé avant !
			
			// close cnx !
			ctx1.close();
			System.out.println("####### connexion closed ok");
			
			//ctx 2 -------------------------------------------------------------------
			System.out.println("####### connexion ... at " + System.currentTimeMillis());
			DirContext ctx2 = new InitialDirContext(ldapTest.envValues);
			System.out.println("####### connexion ok at :" + System.currentTimeMillis());
			
			//test ldapTest avec cardif
			Attributes attrs2 = ctx2.getAttributes("sn=p8admin,cn=cardif,O=BNPP");
			
			//test ldapTest avec ldap local
			//Attributes attrs2 = ctx2.getAttributes("o=CPM_SCANOPS,o=bnpp");
			System.out.println(attrs2.toString());
			
			//la connexion LDAP est réalisé avant !
			
			// close cnx !
			ctx2.close();
			System.out.println("####### connexion closed ok");
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* SERVER LDAP SHUTDOWN =>
	javax.naming.CommunicationException: localhost:10389 [Root exception is java.net.ConnectException: Connection refused: connect]
			at com.sun.jndi.ldap.Connection.<init>(Connection.java:210)
			at com.sun.jndi.ldap.LdapClient.<init>(LdapClient.java:118)
			at com.sun.jndi.ldap.LdapClient.getInstance(LdapClient.java:1580)
			at com.sun.jndi.ldap.LdapCtx.connect(LdapCtx.java:2652)
			at com.sun.jndi.ldap.LdapCtx.<init>(LdapCtx.java:293)
			at com.sun.jndi.ldap.LdapCtxFactory.getUsingURL(LdapCtxFactory.java:175)
			at com.sun.jndi.ldap.LdapCtxFactory.getUsingURLs(LdapCtxFactory.java:193)
			at com.sun.jndi.ldap.LdapCtxFactory.getLdapCtxInstance(LdapCtxFactory.java:136)
			at com.sun.jndi.ldap.LdapCtxFactory.getInitialContext(LdapCtxFactory.java:66)
			at javax.naming.spi.NamingManager.getInitialContext(NamingManager.java:667)
			at javax.naming.InitialContext.getDefaultInitCtx(InitialContext.java:288)
			at javax.naming.InitialContext.init(InitialContext.java:223)
			at javax.naming.InitialContext.<init>(InitialContext.java:197)
			at javax.naming.directory.InitialDirContext.<init>(InitialDirContext.java:82)
			at com.cgi.ldap.test.LdapTest.<init>(LdapTest.java:38)
			at com.cgi.ldap.test.LdapTest.main(LdapTest.java:46)
		Caused by: java.net.ConnectException: Connection refused: connect
			at java.net.PlainSocketImpl.socketConnect(Native Method)
			at java.net.PlainSocketImpl.doConnect(PlainSocketImpl.java:333)
			at java.net.PlainSocketImpl.connectToAddress(PlainSocketImpl.java:195)
			at java.net.PlainSocketImpl.connect(PlainSocketImpl.java:182)
			at java.net.SocksSocketImpl.connect(SocksSocketImpl.java:366)
			at java.net.Socket.connect(Socket.java:529)
			at java.net.Socket.connect(Socket.java:478)
			at java.net.Socket.<init>(Socket.java:375)
			at java.net.Socket.<init>(Socket.java:189)
			at com.sun.jndi.ldap.Connection.createSocket(Connection.java:352)
			at com.sun.jndi.ldap.Connection.<init>(Connection.java:187)
			... 15 more */
	
		/*
			Avec un pool de 1 :

			####### connexion ... at 1411134008568
			Create com.sun.jndi.ldap.LdapClient@1971afc[10.80.136.98:389]
			Use com.sun.jndi.ldap.LdapClient@1971afc
			####### connexion ok at :1411134008610
			{userpassword=userPassword: [B@18020cc, objectclass=objectclass: top, inetOrgPerson, organizationalPerson, person, sn=sn: p8admin, cn=cn: p8admin}
			####### connexion closed ok
			####### connexion ... at 1411134008623
			Release com.sun.jndi.ldap.LdapClient@1971afc
			####### connexion ok at :1411134008623
			Use com.sun.jndi.ldap.LdapClient@1971afc
			{userpassword=userPassword: [B@1ccb029, objectclass=objectclass: top, inetOrgPerson, organizationalPerson, person, sn=sn: p8admin, cn=cn: p8admin}
			Release com.sun.jndi.ldap.LdapClient@1971afc
			####### connexion closed ok
			
			
			Sans pool :
			
			####### connexion ... at 1411134042603
			####### connexion ok at :1411134042644
			{userpassword=userPassword: [B@df8ff1, objectclass=objectclass: top, inetOrgPerson, organizationalPerson, person, sn=sn: p8admin, cn=cn: p8admin}
			####### connexion closed ok
			####### connexion ... at 1411134042657
			####### connexion ok at :1411134042676
			{userpassword=userPassword: [B@34a1fc, objectclass=objectclass: top, inetOrgPerson, organizationalPerson, person, sn=sn: p8admin, cn=cn: p8admin}
			####### connexion closed ok

		*/

}
