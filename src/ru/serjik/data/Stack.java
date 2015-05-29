package ru.serjik.data;

public interface Stack<T> extends Collection<T>
{
	T push(T value);

	T pop();

	T peek();
}
