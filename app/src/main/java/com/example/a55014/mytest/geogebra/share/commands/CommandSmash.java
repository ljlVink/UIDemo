package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.SmashedAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.exception.ParseException;

public class CommandSmash extends Command1A {

	char opt;

	@Override
	public boolean init(TeXParser tp) {
		opt = tp.getOptionAsChar();
		if (opt != 't' && opt != 'b' && opt != '\0') {
			throw new ParseException(tp, "Invalid option in \\smash");
		}
		return true;
	}

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new SmashedAtom(a, opt);
	}
}
