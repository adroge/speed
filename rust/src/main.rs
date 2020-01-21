use rand::prelude::*;
use std::collections::HashMap;
use std::time::Instant;

const ITERATIONS: i64 = 50000000;

fn main() {
	let mut v1 = Vec::<f64>::new();
	let mut v2 = Vec::<f64>::new();
	let mut v_add = Vec::<f64>::new();
	let mut v_sub = Vec::<f64>::new();
	let mut v_mult = Vec::<f64>::new();
	let mut v_div = Vec::<f64>::new();

	let start_time = Instant::now();

	println!("Hello, world!");

	for _j in 0..5 {
		v1 = Vec::<f64>::new();
		v2 = Vec::<f64>::new();
		for _i in 0..ITERATIONS {
			v1.push(get_random_double());
			v2.push(get_random_double());
		}
	}
	log_time("populate vectors 5x", start_time);

	for _j in 0..20 {
		for _i in 0..v1.len() {
			v_add.push(v1[_i] + v2[_i]);
		}
		v_add = Vec::new();

		for _i in 0..v1.len() {
			v_sub.push(v1[_i] - v2[_i]);
		}
		v_sub = Vec::new();

		for _i in 0..v1.len() {
			v_mult.push(v1[_i] * v2[_i]);
		}
		v_mult = Vec::new();

		for _i in 0..v1.len() {
			v_div.push(v1[_i] / v2[_i]);
		}
		v_div = Vec::new();
	}
	log_time("float math 20x", start_time);

	let mut bigmap = HashMap::<String, i64>::new();
	let mut map_values = Vec::<i64>::new();
	let mut vs_keys = Vec::<String>::new();

	for _i in 0..ITERATIONS / 10 {
		bigmap.insert(get_random_string(255), rand::random::<i64>());
	}
	log_time("populate map", start_time);

	for item in bigmap {
		map_values.push(item.1);
		vs_keys.push(item.0);
	}
	bigmap = HashMap::<String, i64>::new();
	map_values.sort();
	vs_keys.sort();
	map_values = Vec::<i64>::new();
	vs_keys = Vec::<String>::new();
	
	log_time("map lookup and sort vectors", start_time);
}

fn get_random_string(len: usize) -> String {
	const CHARACTERS: &str = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	let mut random_string: String = "".to_string();
	let characters_length: usize = CHARACTERS.chars().count();

	for _i in 0..len {
		random_string.push(CHARACTERS.as_bytes()[random::<usize>() % characters_length] as char)
	}

	return random_string;
}

fn get_random_double() -> f64 {
	rand::random::<f64>()
}

fn log_time(msg: &str, since: Instant) {
	println!("{} {:?} seconds", msg, Instant::now() - since)
}
