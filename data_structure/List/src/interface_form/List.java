package interface_form;

public interface List<E> {


    //뒤에 값 추가하기
    boolean add(E value);


    //인덱스에 해당하는 위치에 값 추가하기
    void add(int index, E value);

    //인덱스에 해당하는 요소 삭제하기
    E remove(int index);
    
    //인자에 해당하는 요소 삭제하기
    boolean remove(Object value);

    //index에 해당하는 요소 값 리턴
    E get(int index);

    //index에 해당하는 위치의 요소를 새 요소로 대체
    void set(int index, E value);

    //현재 list에 요소가 있는지
    boolean contains(Object value);

    //요소의 위치가 어디인지
    int indexOf(Object value);

    int size();

    boolean isEmpty();

    public void clear();
}
