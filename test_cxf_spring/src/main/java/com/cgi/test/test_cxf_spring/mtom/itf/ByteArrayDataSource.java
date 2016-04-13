package com.cgi.test.test_cxf_spring.mtom.itf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import javax.activation.DataSource;

/**
 * DataSource helper for byte array data
 * 
 * @author galloisg
 *
 */
public class ByteArrayDataSource implements DataSource {

	/** Data **/
	private byte[] m_data = null;
	/** Content default MIME Type **/
	private String m_type = "application/octet-stream";

	/**
	 * Constructor for ByteArrayDataSource with the given MIME type
	 * 
	 * @param data the byte array
	 * @param type the MIME type of the data
	 */
	public ByteArrayDataSource (byte[] data, String type) {
		m_data = Arrays.copyOf(data, data.length);
		m_type = type;
	}
	

	/**
	 * Constructor for ByteArrayDataSource with default MIME type application/octet-stream
	 * 
	 * @param data the byte array
	 */
	public ByteArrayDataSource (byte[] data) {
		m_data = Arrays.copyOf(data, data.length);
	}

	@Override
	public String getContentType() {
		// return MIME type e.g. application/octet-stream by default
		return m_type;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		if (m_data == null) {
			throw new IOException ("no data");
		}
		// a new stream must be returned each time.
		return new ByteArrayInputStream (m_data);
	}

	@Override
	public String getName() {
		return "ByteArrayDataSource";
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		throw new UnsupportedOperationException("Not implemented");
	}

}
