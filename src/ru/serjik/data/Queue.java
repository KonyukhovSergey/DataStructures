package ru.serjik.data;

public interface Queue<T> extends Collection<T>
{
	T enqueue(T value);

	T dequeue();
}
