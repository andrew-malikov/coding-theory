import { Analyzable } from "./analyzer";
import { Encoding } from "./encoding";
import { Metadata } from "./metadata";

import { createReadStream } from "fs";

export class VolumetricAnalizer implements Analyzable {
  public async analyze(path: string, encoding: Encoding): Promise<Metadata> {
    const metadata = new Metadata(path);

    const file = createReadStream(path);

    metadata.size = 0;

    file.on("data", (chunk: Buffer) => {
      metadata.size += chunk.length;
    });

    file.on("end", () => {
      metadata.size *= encoding.sizePerSymbol;
    });

    return new Promise<Metadata>(resolve => {
      file.on("close", () => {
        resolve(metadata);
      });
    });
  }
}
