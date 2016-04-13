package org.camelcode.otherstuff;

import org.springframework.stereotype.Service;



@Service("otherService")
public class OtherService implements OtherServiceITF {

	@Override
	public void callOtherStuff() {
		System.out.println(this.getClass() + " -> callOtherStuff");
	}

}
