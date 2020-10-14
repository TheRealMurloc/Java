package gui.zad01;

import java.util.ArrayList;

public class Subject {
	String nazwa;
	Person teacher;
	ArrayList<Student> lista = new ArrayList<Student>();

	public Subject(String nazwa) {
		this.nazwa = nazwa;
	}

	public void setTeacher(Person p) {
		this.teacher = p;
	}

	public void addStudent(Student s) throws TooManyStudentsException {
		if (lista.size() >= 10) {
			try {
				throw new TooManyStudentsException();
			} catch (TooManyStudentsException e) {
				throw e;
			}
		} else {
			lista.add(s);
		}
	}

	@Override
	public String toString() {
		return this.nazwa + " - Teacher: " + this.teacher + ", Students: " + this.lista;
	}
}
