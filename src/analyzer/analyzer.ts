import { Encoding } from "./encoding";
import { Metadata } from "./metadata";

export interface Analyzable {
  analyze(path: string, encoding: Encoding): Promise<Metadata>;
}
