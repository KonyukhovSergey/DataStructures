package ru.serjik.data;

public interface List<T> extends Collection<T>
{
	T add(T value);

	T remove(T value);
}
