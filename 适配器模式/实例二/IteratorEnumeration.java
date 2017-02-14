import java.util.*;


/**
 * 旧版本中java给集合类实现迭代器功能是继承Enumeration接口
 * @author ysj
 *
 */
public class IteratorEnumeration implements Enumeration {
	private Iterator iterator;
 
	public IteratorEnumeration(Iterator iterator) {
		this.iterator = iterator;
	}
 
	public boolean hasMoreElements() {
		return iterator.hasNext();
	}
 
	public Object nextElement() {
		return iterator.next();
	}
}
