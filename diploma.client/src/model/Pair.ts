export class Pair<T, V> {

  key: T;
  value: V;

  constructor(_key: T, _value: V) {
    this.key = _key;
    this.value = _value;
  }
}
